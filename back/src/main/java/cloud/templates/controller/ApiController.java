package cloud.templates.controller;

import cloud.templates.model.ApiError;
import cloud.templates.model.ApiVersion;
import cloud.templates.service.api.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(value = "/service")
public class ApiController {

    private final static Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getApiVersion() {
        try {
            return new ResponseEntity<>(new ApiVersion(apiService.getVersion()), HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("getApiVersion() error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiError("error"));
        }
    }

}
