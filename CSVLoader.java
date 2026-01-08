import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CSVLoader {
  
  public static Student loadStudentFromCSV(String filePath) {
    Student student = null;
    
    // Key = subject + date (unique exam)
    HashMap<String, Exam> examMap = new HashMap<>();
    
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line = br.readLine(); // skip header
      
      while ((line = br.readLine()) != null) {
        if (line.trim().isEmpty()) continue; // skip blank lines
        
        String[] parts = line.split(",");
        
        if (parts.length < 5) continue; // skip malformed lines
        
        int studentId = Integer.parseInt(parts[0].trim());
        String subject = parts[1].trim();
        String date = parts[2].trim();
        String topic = parts[3].trim();
        int score = Integer.parseInt(parts[4].trim());
        
        if (student == null) {
          student = new Student(studentId);
        }
        
        String examKey = subject + "_" + date;
        Exam exam = examMap.get(examKey);
        
        if (exam == null) {
          exam = new Exam(subject, date);
          examMap.put(examKey, exam);
          student.addExam(exam);
        }
        
        exam.addTopicScore(new TopicScore(topic, score, 100));
      }
      
    } catch (IOException e) {
      System.out.println("Error reading CSV file");
      e.printStackTrace();
    }
    
    return student;
  }
}

