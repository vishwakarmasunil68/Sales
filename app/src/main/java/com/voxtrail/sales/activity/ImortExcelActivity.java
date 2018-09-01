package com.voxtrail.sales.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.voxtrail.sales.R;
import com.voxtrail.sales.Util.TagUtils;

import java.io.File;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class ImortExcelActivity extends AppCompatActivity {

    @BindView(R.id.btn_import)
    Button btn_import;
    @BindView(R.id.tv_path)
    TextView tv_path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imort_excel);
        ButterKnife.bind(this);

        btn_import.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermission();
            }
        });

    }

    public void checkPermission() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        Permissions.check(this/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
            @Override
            public void onGranted() {
                // do your task.
                openFileManager();
            }
        });
    }

    public void openFileManager() {

        new MaterialFilePicker()
                .withActivity(this)
                .withRequestCode(1)
                .withFilter(Pattern.compile(".*$")) // Filtering files and directories by file name using regexp
                .withFilterDirectories(true) // Set directories filterable (false by default)
                .withHiddenFiles(true) // Show hidden files and folders
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            tv_path.setText(filePath);
            // Do anything with file
            readSheet(filePath);
        }
    }

    public void readSheet(String filePath) {
        File inputWorkBook = new File(filePath);
        Workbook w;
        try {
            w = Workbook.getWorkbook(inputWorkBook);
            Sheet sheet = w.getSheet(0);
            for (int j = 0; j < sheet.getColumns(); j++) {
                for (int i = 0; i < sheet.getRows(); i++) {
                    Cell cell = sheet.getCell(j, i);
                    CellType type = cell.getType();
                    if (type == CellType.LABEL) {
                        Log.d(TagUtils.getTag(), "i got label" + cell.getContents());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//
//    public void readSheet(String file_path) {
//        try {
//            Workbook workbook = WorkbookFactory.create(new File(file_path));
//
//            // Retrieving the number of sheets in the Workbook
//            System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
//
//            // 1. You can obtain a sheetIterator and iterate over it
//            Iterator<Sheet> sheetIterator = workbook.sheetIterator();
//            System.out.println("Retrieving Sheets using Iterator");
//            while (sheetIterator.hasNext()) {
//                Sheet sheet = sheetIterator.next();
//                System.out.println("=> " + sheet.getSheetName());
//            }
//
//            System.out.println("Retrieving Sheets using for-each loop");
//            for (Sheet sheet : workbook) {
//                System.out.println("=> " + sheet.getSheetName());
//            }
//
//
//
//        /*
//           ==================================================================
//           Iterating over all the rows and columns in a Sheet (Multiple ways)
//           ==================================================================
//        */
//
//            // Getting the Sheet at index zero
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Create a DataFormatter to format and get each cell's value as String
//            DataFormatter dataFormatter = new DataFormatter();
//
//            // 1. You can obtain a rowIterator and columnIterator and iterate over them
//            System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
//            Iterator<Row> rowIterator = sheet.rowIterator();
//            while (rowIterator.hasNext()) {
//                Row row = rowIterator.next();
//
//                // Now let's iterate over the columns of the current row
//                Iterator<Cell> cellIterator = row.cellIterator();
//
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    String cellValue = dataFormatter.formatCellValue(cell);
//                    System.out.print(cellValue + "\t");
//                }
//                System.out.println();
//            }
//
//            // 2. Or you can use a for-each loop to iterate over the rows and columns
//            System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
//            for (Row row : sheet) {
//                for (Cell cell : row) {
//                    String cellValue = dataFormatter.formatCellValue(cell);
//                    System.out.print(cellValue + "\t");
//                }
//                System.out.println();
//            }
//
//            // Closing the workbook
//            workbook.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
}
