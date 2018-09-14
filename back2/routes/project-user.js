var express = require('express'),
    jwt     = require('express-jwt'),
    config  = require('../config'),
    db      = require('../db');

var app = module.exports = express.Router();

var jwtCheck = jwt({
  secret: config.secretKey
});

function getAllProjectsOnDb(done){
    db.get().query('SELECT * FROM projectuser WHERE active=1', function(err, rows) {
        if (err) throw err;
        done(rows);
    });
}

app.use('/api/', jwtCheck);

app.get('/api/projectuser', function(req, res) {
    getAllProjectsOnDb(function(result) {
      res.status(200).send(result);
  });
});

function getProjectDB(projectname, done) {
    db.get().query('SELECT * FROM projectuser WHERE projectid = ? LIMIT 1', [projectname], function(err, rows, fields) {
      if (err) throw err;
      //console.log(rows[0]);
      done(rows[0]);
    });
  }

  app.get('/api/projectuser/id', function(req, res) {
    getProjectDB(req.project.username, function(rows){
      res.status(201).send(rows);
    });
  });

app.post('/api/projectuser/create', function(req, res) {  
    if (!req.body.userid || !req.body.projectid) {
      return res.status(400).send("You must send the project and user afectation");
    }
  
    getProjectDB(req.body.projectname, function(project){
      if(!project) {
        project = {
            projectname: req.body.projectname,
            active: req.body.active,
            color: req.body.color
        };
        db.get().query('INSERT INTO projects SET ?', [project], function(err, result){
          if (err) throw err;
          newProject = {
            id: result.insertId,
            projectname: project.projectname,
            active: project.active,
            color: req.body.color
          };

          res.status(201).send(newProject);
        });
      }
      else res.status(400).send("A project with that projectname already exists");
    });
  });

  app.delete('/api/projects/:id', function(req, res){
    db.get().query('DELETE FROM projects WHERE id = ?', [req.params.id], function(err, result){
      if (err) throw err;
      res.status(201).send({result: "OK"});
    });
  });

