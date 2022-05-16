
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class database {
   private Connection con;
   private PreparedStatement pstmt;
   private final String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
   public database() {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         System.out.println("성공했습니다.");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      
   }
   //db연결단
   public void getconnection() {
      try {
         con=DriverManager.getConnection(url,"root","1234");
         System.out.println("계정연결완료");
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   public void disconnection() {
      try {
         if(pstmt!=null) {
            pstmt.close();
            System.out.println("psmt 연결해제");
         }
         if(con!=null) {
            con.close();
            System.out.println("con연결해제");
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
   
   //리스트 목록
      public void mydblistdata() {
         try {
            //db연결
            getconnection();
            //sql 문장 작성
            String sql="select * from news";
            //mysql로 sql쿼리 전송
            pstmt = con.prepareStatement(sql);
            //실행결과를 받아온다.
            ResultSet rs = pstmt.executeQuery();
            //결과를 출력
            while(rs.next()) {
               System.out.println(rs.getInt(1)
               + ","+rs.getString(2));
            }
            
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            disconnection();
         }
      }
      public void newtable() {
         try {
            getconnection();
            PreparedStatement  create = con.prepareStatement("create table news(\r\n"
                  + "title text,content text\r\n"
                  + ");");
            create.executeUpdate();
         }catch(SQLException e) {
            e.printStackTrace();
         }finally {
            disconnection();
         }
      }
      
      public void mydbinsert( String title,String content) {
         try {
            //디비연결
            getconnection();
            //sql문장작성
            String sql="insert into news(title,content) "
                  +"values(?,?)";
            //sql문 전송
            pstmt=con.prepareStatement(sql);
            
            //? 값채우기
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            
            //db값 수정
            //db의 값 업데이트할때1
            pstmt.executeUpdate();
            
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            disconnection();
         }
      }
      public void mydbupdate(int no,String name, String sex,String content) {
         try {
               getconnection();
               String sql="update member set name=?,sex=?,content=?"
                     +"where no=?";
               pstmt = con.prepareStatement(sql);
               pstmt.setString(1, name);
               pstmt.setString(2, sex);
               pstmt.setString(3, content);
               pstmt.setInt(4, no);
               
               pstmt.executeUpdate();
            }catch(Exception e) {
               e.printStackTrace();
            }finally {
               disconnection();
            }
         }
      //삭제
      public void mydbdelete(int no) {
         try {
            getconnection();
            String sql="delete from member where no=?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, no);
            
            pstmt.executeUpdate();
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            disconnection();
         }
      }
      //검색문
      public void select(int no) {
         try {
            getconnection();
            //sql 문장 작성
            String sql="select * from news where no=?";
            //mysql로 sql쿼리 전송
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, no);
            //실행결과를 받아온다.
            ResultSet rs = pstmt.executeQuery();
            //결과를 출력
            while(rs.next()) {
               System.out.println(rs.getString(1)
               + ","+rs.getString(2));
            }
         }catch(Exception e) {
            e.printStackTrace();
         }finally {
            disconnection();
         }
      }
   
//   public static void main(String[] args) {
//      database abc= new database();
//      abc.newtable();
//      abc.getconnection();
////      abc.mydbinsert(5, "이재현","이젠화가나네" , "좆까");
//      
//      abc.mydblistdata();
//      System.out.println("-----------------------");
//      abc.mydbdelete(50);
//      System.out.println("------------------");
//      abc.mydblistdata();
//      System.out.println("==================================");
//      abc.select(3);
//   }
//
}