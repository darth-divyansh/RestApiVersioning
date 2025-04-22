package com.projectversioning.controller;

import com.projectversioning.entities.Name;
import com.projectversioning.entities.PersonV1;
import com.projectversioning.entities.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    // 1st Way of Versioning - URI Based Versioning

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        // Returns only the name for PersonV1
        return new PersonV1("Divyansh Bansal");  // Returning minimal info (name)
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        // Returns full details for PersonV2
        Name name = new Name("Divyansh", "Bansal");
        return new PersonV2(name, 21, "456 Oak Avenue, Dehradun", "divyansh.bansal@example.com");
    }

    // 2nd Way of Versioning - Request Parameter Versioning

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        // Returns only the name for PersonV1
        return new PersonV1("Divyansh Bansal");  // Returning minimal info (name)
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        // Returns full details for PersonV2
        Name name = new Name("Divyansh", "Bansal");
        return new PersonV2(name, 21, "456 Oak Avenue, Dehradun", "divyansh.bansal@example.com");
    }

    // 3rd Way of Versioning - Custom Header Versioning

    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader() {
        // Returns only the name for PersonV1
        return new PersonV1("Divyansh Bansal");  // Returning minimal info (name)
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader() {
        // Returns full details for PersonV2
        Name name = new Name("Divyansh", "Bansal");
        return new PersonV2(name, 21, "456 Oak Avenue, Dehradun", "divyansh.bansal@example.com");
    }

    // 4th Way of Versioning - Media Type Versioning (Content Negotiation)

    @GetMapping(value = "/person", produces = "application/person.v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader() {
        // Returns only the name for PersonV1
        return new PersonV1("Divyansh Bansal");  // Returning minimal info (name)
    }

    @GetMapping(value = "/person", produces = "application/person.v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader() {
        // Returns full details for PersonV2
        Name name = new Name("Divyansh", "Bansal");
        return new PersonV2(name, 21, "456 Oak Avenue, Dehradun", "divyansh.bansal@example.com");
    }
}
