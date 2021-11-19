import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotebookTest {

    Notebook notebook = new Notebook();

    @Test
    public void addTest() throws IOException {
        notebook.add("Mama Mia here I go again");
        notebook.add("Aaa sh here we go again");

        List<Note> notes = notebook.show();
        Assertions.assertEquals("Mama Mia here I go again", notes.get(0).getText());
        Assertions.assertEquals("Aaa sh here we go again", notes.get(1).getText());
    }

    @Test
    public void removeTest() throws IOException {
        notebook.add("Mama Mia here I go again");
        notebook.add("Aaa sh here we go again");
        notebook.remove("Mama Mia here I go again");
        notebook.remove("Aaa sh here we go again");

        List<Note> notes = notebook.show();
        Assertions.assertEquals(0, notes.size());
    }

    @Test
    public void showTest() throws IOException {
        notebook.add("Mama Mia here I go again");
        notebook.add("Aaa sh here we go again");
        List<Note> notes = notebook.show();
        System.out.println(notebook.show());
    }

   /*  @Test
        public void searchTest() throws IOException {
        notebook.add("Mama Mia here I go again");
        notebook.add("Aaa sh here we go again");
        String date1 = "2021-11-19";
        String date2 = "2021-11-20";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDateTime  since = LocalDate.parse(date1, formatter).atStartOfDay();;
        LocalDateTime  till = LocalDate.parse(date2, formatter).atStartOfDay();;
        System.out.println(notebook.show(since, till, "again"));
    } */
}