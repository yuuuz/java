package zy.office;

/**
 * 2018/1/5 21:57
 */

import java.io.*;
import java.sql.*;
import java.util.Scanner;
import zy.office.Login;

public class Office3
{
    public static void wj()
    {
        System.out.println("文件编号"+"\t文件名称"+"\t文件类型"+"\t存储位置");
    }
    public static void kq()
    {
        System.out.println("编号"+"\t员工编号"+"\t时间"+"\t出勤情况");
    }
    public static void hy()
    {
        System.out.println("会议编号"+"\t会议时间"+"\t会议内容"+"\t参会人"+"\t\t记录人");
    }
    public static void yg(){
        System.out.println("员工编号"+"\t姓名"+"\t性别"+"\t年龄" +"\t职位");
    }

    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String user = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        if (Login.Check(user,password)) {
            System.out.println("登陆成功！");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                System.out.println("出错");
                return;
            }
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office2", "root", "hhxxttxs123");
                Statement stmt = con.createStatement();
                int z = 1;
                while (z != 0) {
                    System.out.println("-----------------------------------");
                    System.out.println("1.查询2.插入3.修改4.删除5.退出系统");
                    System.out.println("按除上诉任意键返回主界面");
                    System.out.println("-----------------------------------");
                    System.out.println("请选择：");
                    int x = 0;
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        x = Integer.parseInt(br.readLine());
                    } catch (IOException ex) {
                    }
                    if (x == 5) z = 0;
                    if (x == 1) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("1.文件信息查询2.考勤信息查询3.会议记录查询4.员工信息查询");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("请选择：");
                        int i = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            i = Integer.parseInt(br.readLine());
                        } catch (IOException ex) {
                        }
                        if (i == 1) {
                            ResultSet rs = stmt.executeQuery("select WNo,WName,WType,WPlace from wj");
                            wj();
                            while (rs.next()) {
                                int a = rs.getInt("WNo");
                                String b = rs.getString("WName");
                                String c = rs.getString("WType");
                                String d = rs.getString("WPlace");
                                System.out.println(a + "\t\t" + b + "\t\t" + c + "\t\t" + d);
                            }
                        }
                        if (i == 2) {
                            ResultSet rs = stmt.executeQuery("select KNo,YNo,YTime,YC from kq");
                            kq();
                            while (rs.next()) {
                                int a = rs.getInt("KNo");
                                int b = rs.getInt("YNo");
                                String c = rs.getString("YTime");
                                String d = rs.getString("YC");
                                System.out.println(a + "\t\t" + b + "\t\t" + c + "\t\t" + d);
                            }
                        }

                        if (i == 3) {
                            ResultSet rs = stmt.executeQuery("select MNo,MTime,MContent,MPeople1,MPeople2,MPeople3,MRecorder from hy");
                            hy();
                            while (rs.next()) {
                                int a = rs.getInt("MNo");
                                String b = rs.getString("MTime");
                                String c = rs.getString("MContent");
                                int d = rs.getInt("MPeople1");
                                int e = rs.getInt("MPeople2");
                                int f = rs.getInt("MPeople3");
                                String g = rs.getString("MRecorder");
                                System.out.println(a + "\t\t" + b + "\t\t" + c + "\t" + d + "\t" + e + "\t" + f + "\t" + g);
                            }
                        }
                        if(i == 4){
                            ResultSet rs = stmt.executeQuery("select YNo,YName,Sex,Age,Post from yg");
                            yg();
                            while (rs.next()) {
                                int a = rs.getInt("YNo");
                                String b = rs.getString("YName");
                                String c = rs.getString("Sex");
                                int d = rs.getInt("Age");
                                String e = rs.getString("Post");
                                System.out.println(a + "\t\t\t" + b + "\t" + c + "\t\t" + d + "\t\t" + e);
                            }
                        }
                    }
                    if (x == 2) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("1.文件信息插入2.考勤信息插入3.会议记录插入4.员工信息插入");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("请选择：");
                        int m = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            m = Integer.parseInt(br.readLine());
                        } catch (IOException ex) {
                        }
                        if (m == 1) {
                            String c1 = "", c2 = "", c3 = "", c4 = "";
                            System.out.println("输入你要插入的文件编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c1=" + c1);
                            System.out.println("输入你要插入的文件名称：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c2 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c2=" + c2);
                            System.out.println("输入你要插入的文件种类：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c3 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c3=" + c3);
                            System.out.println("输入你要插入的存储位置：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c4 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c4=" + c4);
                            PreparedStatement pstmt2 = con.prepareStatement("insert into wj values(?,?,?,?)");
                            pstmt2.setString(1, c1);
                            pstmt2.setString(2, c2);
                            pstmt2.setString(3, c3);
                            pstmt2.setString(4, c4);
                            pstmt2.executeUpdate();
                            System.out.println("插入成功!");
                            pstmt2.close();
                            //pstmt1.close();
                            //rs2.close();
                        }
                        if (m == 2) {
                            String c1 = "", c2 = "", c3 = "", c4 = "";
                            //PreparedStatement pstmt1=con.prepareStatement("select * from Memo where Uname=?");
                            //pstmt1.setString(1,c1);
                            //ResultSet rs2=pstmt1.executeQuery();
                            System.out.println("输入你要插入的编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c1=" + c1);
                            System.out.println("输入你要插入的员工编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c2 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c2=" + c2);
                            System.out.println("输入你要插入的时间(例2000/1/1)：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c3 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c3=" + c3);
                            System.out.println("输入你要插入的出勤情况：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c4 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c4=" + c4);
                            PreparedStatement pstmt2 = con.prepareStatement("insert into kq values(?,?,?,?)");
                            pstmt2.setString(1, c1);
                            pstmt2.setString(2, c2);
                            pstmt2.setString(3, c3);
                            pstmt2.setString(4, c4);
                            pstmt2.executeUpdate();
                            System.out.println("插入成功!");
                            pstmt2.close();
                        }
                        if (m == 3) {
                            String c1 = "", c2 = "", c3 = "", c4 = "", c5 = "";
                            System.out.println("输入你要插入的会议编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c1=" + c1);
                            System.out.println("输入你要插入的会议时间（例2010/1/1）：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c2 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c2=" + c2);
                            System.out.println("输入你要插入的会议内容：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c3 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c3=" + c3);
                            System.out.println("输入你要插入的参会人：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c4 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c4=" + c4);
                            System.out.println("输入你要插入的记录人：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c5 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c5=" + c5);
                            PreparedStatement pstmt2 = con.prepareStatement("insert into hy values(?,?,?,?,?)");
                            pstmt2.setString(1, c1);
                            pstmt2.setString(2, c2);
                            pstmt2.setString(3, c3);
                            pstmt2.setString(4, c4);
                            pstmt2.setString(5, c5);
                            pstmt2.executeUpdate();
                            System.out.println("插入成功!");
                            pstmt2.close();
                        }
                        if (m == 4){
                            String c1 = "", c2 = "", c3 = "", c4 = "", c5 = "";
                            System.out.println("输入你要插入的员工编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c1=" + c1);
                            System.out.println("输入你要插入的姓名：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c2 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c2=" + c2);
                            System.out.println("输入你要插入的性别：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c3 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c3=" + c3);
                            System.out.println("输入你要插入的年龄：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c4 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c4=" + c4);
                            System.out.println("输入你要插入的职位：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                c5 = br.readLine();
                            } catch (IOException ex) {
                            }
                            System.out.println("c5=" + c5);
                            PreparedStatement pstmt2 = con.prepareStatement("insert into yg values(?,?,?,?,?)");
                            pstmt2.setString(1, c1);
                            pstmt2.setString(2, c2);
                            pstmt2.setString(3, c3);
                            pstmt2.setString(4, c4);
                            pstmt2.setString(5, c5);
                            pstmt2.executeUpdate();
                            System.out.println("插入成功!");
                            pstmt2.close();
                        }
                    }
                    if (x == 3) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("1.文件信息修改2.考勤信息修改3.会议记录修改4.员工信息修改");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("请选择：");
                        int m = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            m = Integer.parseInt(br.readLine());
                        } catch (IOException ex) {
                        }
                        if (m == 1) {
                            String m11 = "";
                            String m13 = "";
                            int m12 = 0;
                            System.out.println("选择你要修改文件的编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                m11 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt31 = con.prepareStatement("select * from wj where WNo=?");
                            pstmt31.setString(1, m11);
                            ResultSet rs3 = pstmt31.executeQuery();
                            if (rs3.next()) {
                                System.out.println("输入你要修改的项：1.文件名称2.文件种类3.存储位置");
                                try {
                                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                    m12 = Integer.parseInt(br.readLine());
                                } catch (IOException ex) {
                                }
                                if (m12 == 1) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update wj set WName=? where  WNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                }
                                if (m12 == 2) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update wj set WType=? where  WNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                                if (m12 == 3) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update wj set WPlace=? where WNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                            } else {
                                System.out.println("你要更改的项不存在!");
                            }
                        }
                        if (m == 2) {
                            String m11 = "";
                            String m13 = "";
                            int m12 = 0;
                            System.out.println("选择你要修改的编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                m11 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt31 = con.prepareStatement("select * from kq where KNo=?");
                            pstmt31.setString(1, m11);
                            ResultSet rs3 = pstmt31.executeQuery();
                            if (rs3.next()) {
                                System.out.println("输入你要修改的项：1.员工编号2.时间3.出勤情况");
                                try {
                                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                    m12 = Integer.parseInt(br.readLine());
                                } catch (IOException ex) {
                                }
                                if (m12 == 1) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update kq set YNo=? where  KNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                }
                                if (m12 == 2) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update kq set YTime=? where KNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                                if (m12 == 3) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update kq set YC=? where KNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                            } else {
                                System.out.println("你要更改的项不存在!");
                            }
                        }
                        if (m == 3) {
                            String m11 = "";
                            String m13 = "";
                            int m12 = 0;
                            System.out.println("选择你要修改会议编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                m11 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt31 = con.prepareStatement("select * from hy where MNo=?");
                            pstmt31.setString(1, m11);
                            ResultSet rs3 = pstmt31.executeQuery();
                            if (rs3.next()) {
                                System.out.println("输入你要修改的项：1.会议时间2.会议内容3.参会人4.记录人");
                                try {
                                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                    m12 = Integer.parseInt(br.readLine());
                                } catch (IOException ex) {
                                }
                                if (m12 == 1) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update hy set MTime=? where  MNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                }
                                if (m12 == 2) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update hy set MContent=? where  MNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                                if (m12 == 3) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update hy set MPeople=? where MNo=?");
                                    pstmt3.setString(1, m13);
                                    //pstmt3.setint(2,m11);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                                if (m12 == 4) {
                                    System.out.println(" 输入你修改后的值:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update hy set MRecorder=? where MNo=?");
                                    pstmt3.setString(1, m13);
                                    //pstmt3.setint(2,m11);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                            } else {
                                System.out.println("你要更改的项不存在!");
                            }
                        }
                        if (m == 4) {
                            String m11 = "";
                            String m13 = "";
                            int m12 = 0;
                            System.out.println("选择你要修改员工编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                m11 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt31 = con.prepareStatement("select * from yg where YNo=?");
                            pstmt31.setString(1, m11);
                            ResultSet rs3 = pstmt31.executeQuery();
                            if (rs3.next()) {
                                System.out.println("输入你要修改的项：1.员工姓名2.性别3.年龄4.职位");
                                try {
                                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                    m12 = Integer.parseInt(br.readLine());
                                } catch (IOException ex) {
                                }
                                if (m12 == 1) {
                                    System.out.println(" 输入你修改后的姓名:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update yg set YName=? where  YNo=?");
                                    pstmt3.setString(1, m13);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                }
                                if (m12 == 2) {
                                    System.out.println(" 输入你修改后的性别:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update yg set Sex=? where  YNo=?");
                                    pstmt3.setString(1, m13);
                                    //pstmt3.setint(2,m11);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                    //pstmt3.close();
                                }
                                if (m12 == 3) {
                                    System.out.println(" 输入你修改后的年龄:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update yg set Age=? where YNo=?");
                                    pstmt3.setString(1, m13);
                                    //pstmt3.setint(2,m11);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                                if (m12 == 4) {
                                    System.out.println(" 输入你修改后的职位:");
                                    try {
                                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                        m13 = br.readLine();
                                    } catch (IOException ex) {
                                    }
                                    pstmt31.close();
                                    PreparedStatement pstmt3 = con.prepareStatement("Update kq set Post=? where YNo=?");
                                    pstmt3.setString(1, m13);
                                    //pstmt3.setint(2,m11);
                                    pstmt3.setString(2, m11);
                                    pstmt3.executeUpdate();
                                    System.out.println("修改成功!");
                                    rs3.close();
                                }
                            } else {
                                System.out.println("你要更改的项不存在!");
                            }
                        }
                    }


                    if (x == 4) {
                        System.out.println("-------------------------------------------------------");
                        System.out.println("1.文件信息删除2.考勤信息删除3.会议记录删除4.员工信息删除");
                        System.out.println("-------------------------------------------------------");
                        System.out.println("请选择：");
                        int i = 0;
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            i = Integer.parseInt(br.readLine());
                        } catch (IOException ex) {
                        }
                        if (i == 1) {
                            String S1 = "";
                            System.out.println("输入你要删除的文件信息表中的文件编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                S1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt41 = con.prepareStatement("select * from wj where WNo=?");
                            pstmt41.setString(1, S1);
                            ResultSet rs4 = pstmt41.executeQuery();
                            if (rs4.next()) {
                                PreparedStatement pstmt2 = con.prepareStatement("delete from wj where WNo=?");
                                pstmt2.setString(1, S1);
                                pstmt2.executeUpdate();
                                System.out.println("已删除!");
                                pstmt2.close();
                            }else {
                                System.out.println("你要删除的项不存在");
                            }
                        }
                        if (i == 2) {
                            String S1 = "";
                            System.out.println("输入你要删除的考勤信息表的编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                S1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt42 = con.prepareStatement("select * from kq where KNo=?");
                            pstmt42.setString(1, S1);
                            ResultSet rs4 = pstmt42.executeQuery();
                            if (rs4.next()) {
                                PreparedStatement pstmt2 = con.prepareStatement("delete from kq where KNo=?");
                                pstmt2.setString(1, S1);
                                pstmt2.executeUpdate();
                                System.out.println("已删除!");
                                pstmt2.close();
                            }else {
                                System.out.println("你要删除的项不存在");
                            }
                        }
                        if (i == 3) {
                            String S1 = "";
                            System.out.println("输入你要删除的会议信息表的会议编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                S1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt43 = con.prepareStatement("select * from hy where MNo=?");
                            pstmt43.setString(1, S1);
                            ResultSet rs4 = pstmt43.executeQuery();
                            if (rs4.next()) {
                                PreparedStatement pstmt2 = con.prepareStatement("delete from hy where MNo=? ");
                                pstmt2.setString(1, S1);
                                pstmt2.executeUpdate();
                                System.out.println("已删除!");
                                pstmt2.close();
                            }else{
                                System.out.println("你要删除的项不存在");
                            }
                        }
                        if (i == 4) {
                            String S1 = "";
                            System.out.println("输入你要删除的员工的员工编号：");
                            try {
                                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                                S1 = br.readLine();
                            } catch (IOException ex) {
                            }
                            PreparedStatement pstmt44 = con.prepareStatement("select * from yg where YNo=?");
                            pstmt44.setString(1, S1);
                            ResultSet rs4 = pstmt44.executeQuery();
                            if (rs4.next()) {
                                PreparedStatement pstmt2 = con.prepareStatement("delete from yg where YNo=? ");
                                pstmt2.setString(1, S1);
                                pstmt2.executeUpdate();
                                System.out.println("已删除!");
                                pstmt2.close();
                            }else{
                                System.out.println("你要删除的项不存在");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            System.out.println("用户名或密码不正确");
        }
    }
}

