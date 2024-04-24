    package obile.takeflights.com.takeflights.Controllers;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    class Hello {

        @GetMapping("/hello")
        String helloWorld() {
            return "Hello World";
        }
    }
