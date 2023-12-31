package web.capstone.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.capstone.model.Report;
import web.capstone.services.ReportService;

@RestController
@RequestMapping("/api/v1/reports")
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
