package web.capstone.services;

import web.capstone.model.request.Report;

import java.util.List;

public interface ReportService {
    List<Report> getAllUserReports(Long userId);
}
