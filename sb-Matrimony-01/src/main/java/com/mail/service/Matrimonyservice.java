package com.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.mail.model.Matrimony;
import com.mail.repository.Matrimonyrepo;

@Service
public class Matrimonyservice {
    
    @Autowired
    private JavaMailSender javaMailSender;
    
    @Autowired
    private Matrimonyrepo matrimonyrepo;

    public Matrimony login(String email, String password) {
        Matrimony matrimony = matrimonyrepo.findByEmail(email);
        if (matrimony != null && matrimony.getPassword().equals(password)) {
            matrimony.generateotp();
            matrimonyrepo.save(matrimony);
            sendOtpMail(matrimony);
            return matrimony;
        }
        return null;
    }
    
    public void sendOtpMail(Matrimony matrimony) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("rajeevmedari@gmail.com");
        message.setTo(matrimony.getEmail());
        message.setSubject("From Matrimony");
        message.setText("Your OTP code is " + matrimony.getOtp());
        javaMailSender.send(message);
    }

    public Matrimony saveUser(String name, String mobileNo, String job, String email, String password) {
    	Matrimony matrimony = new Matrimony();
        // Check if email already exists
        if (matrimonyrepo.existsByEmail(email)) {
            // Handle duplicate email scenario, for example:
           return  matrimony=null;
        }

        // If email doesn't exist, proceed with saving the user
        
        matrimony.setName(name);
        matrimony.setMobileno(mobileNo);
        matrimony.setJob(job);
        matrimony.setEmail(email);
        matrimony.setPassword(password);
        matrimonyrepo.save(matrimony);
        return matrimony;
    }


	public Matrimony verifyotp(String email,String otp) {
		Matrimony matrimony=matrimonyrepo.findByEmail(email);
		if(matrimony!= null && matrimony.getOtp().equals(otp)) { ;
		return matrimony;
		}
		else {
			matrimony=null;
			return matrimony;
		}
	}

	public List<Matrimony> viewusers() {
	List<Matrimony> mony=matrimonyrepo.findAll();
		return mony ;
	}

}
