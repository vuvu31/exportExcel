package project.apicapstone.common.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import project.apicapstone.entity.Contract;
import project.apicapstone.repository.ContractRepository;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExporterExcelEmployee {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private ContractRepository contractRepository;

    private List<Contract> listEmployee;
    private Contract contract;
    private String contractt;

    private int i = 1;
    /*public ExporterExcelEmployee(String contractt) {
        this.contractt = contractt;
    }*/

    public ExporterExcelEmployee(List<Contract> listEmployee) {
        this.listEmployee = listEmployee;
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        }
        else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeHeaderRow() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Hồ Sơ NV");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        createCell(row, 0, "Số TT", style);
        createCell(row, 1, "Số HĐ", style);
        createCell(row, 2, "HỌ VÀ TÊN", style);
        createCell(row, 3, "ĐIỆN THOẠI", style);
        createCell(row, 4, "EMAIL", style);
        createCell(row, 5, "NGÀY NHẬN VIỆC", style);
        createCell(row, 6, "NGÀY SINH", style);
        createCell(row, 7, "NƠI SINH", style);
        createCell(row, 8, "GIỚI TÍNH", style);
        createCell(row, 9, "DÂN TỘC", style);
        createCell(row, 10, "TÔN GIÁO", style);
        createCell(row, 11, "TRÌNH ĐỘ HỌC VẤN", style);
        createCell(row, 12, "CMND SỐ", style);
        createCell(row, 13, "NGÀY CẤP", style);
        createCell(row, 14, "NƠI CẤP", style);
        createCell(row, 15, "ĐỊA CHỈ THƯỜNG TRÚ ", style);
        createCell(row, 16, "CHỨC DANH", style);
        createCell(row, 17, "LOẠI HỢP ĐỒNG", style);
        createCell(row, 18, "NGÀY KÝ ", style);
        createCell(row, 19, "THÁNG KÝ", style);
        createCell(row, 20, "NĂM KÝ", style);
        createCell(row, 21, "NGÀY LÀM", style);
        createCell(row, 22, "THÁNG LÀM", style);
        createCell(row, 23, "NĂM LÀM", style);
        createCell(row, 24, "NGÀY KẾT THÚC", style);
        createCell(row, 25, "THÁNG KẾT THÚC", style);
        createCell(row, 26, "NĂM KẾT THÚC", style);
        createCell(row, 27, "TÌNH TRẠNG HÔN NHÂN ", style);
        createCell(row, 28, "LIÊN HỆ ", style);
    }

    private void writeEmployeeRowList() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        for (Contract contract : listEmployee) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, i++, style);
            createCell(row, columnCount++, contract.getContractId(), style); //số HĐ
            createCell(row, columnCount++, contract.getEmployee().getEmployeeName(), style);
            createCell(row, columnCount++, contract.getEmployee().getPhone(), style);
            createCell(row, columnCount++, contract.getEmployee().getEmail(), style);
            createCell(row, columnCount++, contract.getStartDate().toString(), style); //Ngày nhận việc
            createCell(row, columnCount++, contract.getEmployee().getDateBirth().toString(), style);
            createCell(row, columnCount++, contract.getEmployee().getPlaceBirth(), style);
            createCell(row, columnCount++, contract.getEmployee().getGender(), style);
            createCell(row, columnCount++, contract.getEmployee().getEthnic(), style);
            createCell(row, columnCount++, contract.getEmployee().getReligion(), style);
            createCell(row, columnCount++, contract.getEmployee().getAcademicLevel(), style);
            createCell(row, columnCount++, contract.getEmployee().getEmployeeId(), style); //Số CMND
            createCell(row, columnCount++, contract.getEmployee().getDateIssue().toString(), style); //Ngày cấp (CMND)
            createCell(row, columnCount++, contract.getEmployee().getPlaceIssue(), style); //Nơi cấp (CMND)
            createCell(row, columnCount++, contract.getEmployee().getAddress(), style);
            createCell(row, columnCount++, contract.getEmployee().getTitle().getJobTitle(), style); //Chức Danh
            createCell(row, columnCount++, contract.getType(), style); //Loại hợp đồng
            createCell(row, columnCount++, contract.getSignDate().getDayOfMonth(), style); //Ngày ký
            createCell(row, columnCount++, contract.getSignDate().getMonthValue(), style); //Tháng ký
            createCell(row, columnCount++, contract.getSignDate().getYear(), style); //Năm ký
            createCell(row, columnCount++, contract.getStartDate().getDayOfMonth(), style); //Ngày làm
            createCell(row, columnCount++, contract.getStartDate().getMonthValue(), style); //Tháng làm
            createCell(row, columnCount++, contract.getStartDate().getYear(), style); //Năm làm
            createCell(row, columnCount++, contract.getEndDate().getDayOfMonth(), style); //Ngày kết thúc
            createCell(row, columnCount++, contract.getEndDate().getMonthValue(), style); //Tháng kết thúc
            createCell(row, columnCount++, contract.getEndDate().getYear(), style); //Năm kết thúc
            createCell(row, columnCount++, contract.getEmployee().getMaritalStatus(), style);
            createCell(row, columnCount++, contract.getEmployee().getPhone(), style); //Liên hệ
        }
    }

    public void exportListEmployee(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeEmployeeRowList();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}