package top.itrator.leyouyouProgramming.word;

import com.google.common.collect.Lists;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordWriteDemo {
    
    @Test
    public void test_write_demo() throws IOException {
        List<String> lines = createLines(1000);

        int pageLineCnt = 20;
        List<List<String>> subLists = Lists.partition(lines, pageLineCnt);


        XWPFDocument document = new XWPFDocument();
        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("createdWord.docx"));

        for(List<String> pages : subLists) {
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();

            run.addCarriageReturn();
            for (String line: pages) {
                run.setText(line);
                run.addCarriageReturn();
            }

            paragraph.setPageBreak(true);
        }

        document.write(out);

        out.close();
    }

    private List<String> createLines(int totalLineCnt) {
        List<String> result = Lists.newArrayList();
        for (int i=0;i<totalLineCnt;i++) {
            result.add("line_" + i);
        }

        return result;
    }
}
