package project.apicapstone.common.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import project.apicapstone.entity.Contract;
import project.apicapstone.repository.ContractRepository;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExportExcelContract {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private ContractRepository contractRepository;

    private List<Contract> listContract;
    private Contract contract;

    private int i = 1;

    public ExportExcelContract(List<Contract> listContract) {
        this.listContract = listContract;
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
        else if (value instanceof Double){
            cell.setCellValue((Double) value);
        } else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeHeaderRow() {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Hợp Đồng Lao Động");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);

        createCell(row, 0, "Số TT", style);
        createCell(row, 1, "Số HĐ", style);
        createCell(row, 2, "NHÂN VIÊN", style);
        createCell(row, 3, "TÊN HỢP ĐỒNG", style);
        createCell(row, 4, "CHỨC DANH", style);
        createCell(row, 5, "LOẠI HỢP ĐỒNG", style);
        createCell(row, 6, "NGÀY KÝ HỢP ĐỒNG", style);
        createCell(row, 7, "THỜI HẠN HỢP ĐỒNG (THEO THÁNG)", style);
        createCell(row, 8, "NGÀY BẮT ĐẦU", style);
        createCell(row, 9, "NGÀY KẾT THÚC", style);
        createCell(row, 10, "LƯƠNG CƠ BẢN", style);
        createCell(row, 11, "MỨC LƯƠNG", style);
        createCell(row, 12, "TRẠNG THÁI HỢP ĐỒNG", style);
        createCell(row, 13, "THÔNG TIN THÊM", style);
    }

    private void writeContractRowList() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        for (Contract contract : listContract) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, i++, style);
            createCell(row, columnCount++, contract.getContractId(), style); //số HĐ
            createCell(row, columnCount++, contract.getEmployee().getEmployeeName(), style);
            createCell(row, columnCount++, contract.getContractName(), style);
            createCell(row, columnCount++, contract.getEmployee().getTitle().getJobTitle(), style); //Chức Danh
            createCell(row, columnCount++, contract.getType(), style); //Loại hợp đồng
            createCell(row, columnCount++, contract.getSignDate().toString(), style);
            createCell(row, columnCount++, contract.getDuration().toString(), style);
            createCell(row, columnCount++, contract.getStartDate().toString(), style);
            createCell(row, columnCount++, contract.getEndDate().toString(), style);
            createCell(row, columnCount++, contract.getSalary(), style);
            createCell(row, columnCount++, contract.getWage(), style);
            createCell(row, columnCount++, contract.getStatus(), style);
            createCell(row, columnCount++, contract.getNote(), style);
        }
    }

    public void exportListContract(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeContractRowList();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }
}
