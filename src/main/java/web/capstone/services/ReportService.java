package web.capstone.services;

import java.util.List;
import web.capstone.model.Report;

public interface ReportService {

  List<Report> getAllUserReports(Long userId);
}
