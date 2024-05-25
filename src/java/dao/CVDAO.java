/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CVProfile;
import model.User;

/**
 *
 * @author Admin
 */
public class CVDAO extends DBContext implements BaseDAO<CVProfile> {

    //Cv task
    @Override
    public CVProfile findByEmail(String email) {
        String sql = "Select TOP 1 * from CVProfile where UserID = (select UserID from Users where Email = ? )\n" +
        "Order by Number Desc ";
        
        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int cvId = rs.getInt(1);
                int userId = rs.getInt(2);
                String skills = rs.getString(3);
                String experience = rs.getString(4);
                String description = rs.getString(5);
                String education = rs.getString(6);
                String certifications = rs.getString(7);
                String linkUrl = rs.getString(8);
                int number = rs.getInt(9);
                String avatar = rs.getString(10);
                String linkPdf = rs.getString(11);
                
                CVProfile cv = new CVProfile(cvId, userId, number, skills, experience, description, education, certifications, linkUrl, avatar,linkPdf);
                return cv;

            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
    

    @Override
    public List<CVProfile> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CVProfile findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(CVProfile newObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(CVProfile newObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getRoleByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateUserFromCV(String email, String firstName, String lastName, String phoneNumber, String newEmail, String city) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateCVProfileFromCV(String linkPdf, String education, String skills, String experience, String certification, String description, String linkUrl, String email) {
        String sql = "Update CVProfile\n"
                + "		 set LinkPdf = ? , \n"
                + "		 Education = ? , \n"
                + "		 Skills = ? , \n"
                + "		 Experience = ? , \n"
                + "		 Certifications = ? , \n"
                + "		 Description = ? , \n"
                + "		 LinkUrl = ?  \n"
                + "		Where CVId = (Select TOP 1 CVId from CVProfile where UserID = (select UserID from Users where Email = ? ) Order by Number Desc)";
        PreparedStatement ps;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, linkPdf);
            ps.setString(2, education);
            ps.setString(3, skills);
            ps.setString(4, experience);
            ps.setString(5, certification);
            ps.setString(6, description);
            ps.setString(7, linkUrl);
            ps.setString(8, email);
            
            int rowAffect = ps.executeUpdate();
            if (rowAffect > 0) {
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(JobseekerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
