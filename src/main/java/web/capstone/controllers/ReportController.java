package web.capstone.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.capstone.model.Report;
import web.capstone.services.ReportService;

import java.util.List;

@RestController
@RequestMapping("")
public class ReportController {
    final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping(path = "/myreports")
    public ResponseEntity<List<Report>> getMyReports(@RequestParam Long userId) {
        return new ResponseEntity<>(reportService.getAllUserReports(userId), HttpStatus.OK);
    }
}
