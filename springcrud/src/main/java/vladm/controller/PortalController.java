package vladm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {

    @RequestMapping(value = "/employees")
    public String employeesList() { return "employees"; }

    @RequestMapping(value = "/statuses")
    public String statusessList() { return "statuses"; }

    @RequestMapping(value = "")
    public String mainPage() { return "main"; }
}
