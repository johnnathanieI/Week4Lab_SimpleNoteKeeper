package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author johnn
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
        // to retrieve the data from BufferedReader
        StringBuilder sb = new StringBuilder();
        

        Note note = new Note();
        String line = br.readLine();
        String title = sb.append(line).toString();
        note.setTitle(title);
        //Clears the currently appended string for content space
        sb.delete(0, sb.lastIndexOf(sb.toString()));
        
        String content = "";
        
        //First reads line after title to implement into content
        String contentReader = br.readLine();
        
        //Checks if there is a next line and if there is it gets added into content and breaks into a new line
        if (br.ready()) {
            do {
                sb.append(contentReader + "<br>");
            } while (contentReader != null);
        }
        
        content = sb.toString();
       
        note.setContents(content);
        
        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }
}
