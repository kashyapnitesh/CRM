package com.zohocrm.service.impl;

import com.zohocrm.entity.Lead;
import com.zohocrm.exception.LeadExist;
import com.zohocrm.payload.LeadDto;
import com.zohocrm.repository.LeadRepository;
import com.zohocrm.service.LeadService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LeadServiceImpl implements LeadService {

    private LeadRepository leadrepo;

    public LeadServiceImpl(LeadRepository leadrepo, ModelMapper modelMapper) {
        this.leadrepo = leadrepo;
        this.modelMapper = modelMapper;
    }

    private ModelMapper modelMapper;

    @Override
    public LeadDto createLead(LeadDto leadDto) {

        boolean emailExists = leadrepo.existsByEmail(leadDto.getEmail());
        boolean mobileExists = leadrepo.existsByMobile(leadDto.getMobile());

         if (emailExists){
             throw new LeadExist("email exist - "+leadDto.getEmail());

         }
             if(mobileExists){
                 throw new LeadExist("mobile exist - "+leadDto.getMobile());

             }

        Lead lead = mapToEntity(leadDto);
        String lid = UUID.randomUUID().toString();
        lead.setLid(lid);        // see whenever we working in most of the application we dont give id no. as 1,2,3,4...and all because when it become very obvious people brek down of your application becaause id no.'s are open imagine you save record the other person with your UI only they hack the id no.'s so we generate randomUUID no.'s because nobody performe some SQL injection(SQL injection is kind of a hacking technique, which hackers are use it they inject the SQLQueries to your fields of your application)
        Lead savedlead = leadrepo.save(lead);

        LeadDto dto = mapToDto(savedlead);
                                             // ye line ye kahna chahti hai ki "leadrepo"(repo means database or hum jante hai database mai entity(JAVA OBJECT) jata hai to dekho or check karo or agar Email db mai exists karta hai to usko alt+enter daba ke introduce a local variable mai save karo(emailExists ye kuch bhi naam de sakte hai variable ka)
        return dto;
    }

    @Override
    public void deleteLeadById(String lid) {
        Lead lead = leadrepo.findById(lid).orElseThrow(
                () -> new LeadExist("Lead with this id not present - " + lid)
        );
        leadrepo.deleteById(lid);
    }

    @Override
    public List<LeadDto> getAllLeads() {
        List<Lead> leads = leadrepo.findAll();
        return leads.stream().map(lead ->mapToDto(lead)).collect(Collectors.toList());
    }

    @Override
    public List<Lead> getLeadsExcelReports() {
        return leadrepo.findAll();
    }


    Lead mapToEntity(LeadDto leadDto){        // yaha hum LeadDto(ye JSON Object hai convert kar rahe hai JAVA Object mai,JAVA Object Entity class mai hota hai) or fir usko hum Lead mai save kar rahe hai
        Lead lead = modelMapper.map(leadDto, Lead.class);
        return lead;                                    // is line se hume ye pata chal raha hai ki leadDto(JSON) convert ho gaya hai JAVA object mai(or hume pata hai entity class mai to JAVA object hi hote hai,,,or yaha hume "map" method ka use kia hai or BOLA HAI Lead.class mai map kar do                                    // "maptoEntity"   likh kar hum aisa kar paa rahe hai.(maptoEntity ko use karne ke liye hume "modelmapper" dependency add karni padti hai pom.xml file mai) or usko alt+enter daba ke lead(Lead lead) variable mai save kar liya hai
    }

    LeadDto mapToDto(Lead lead){        //yaha hum Lead(ye JAVA Object hai convert kar rahe hai JASON Object mai,JASON Object Dto class mai hota hai) or fir usko hum LeadDto mai save kar rahe hai
        LeadDto leadDto = modelMapper.map(lead, LeadDto.class);
             return leadDto;                                               //    "mapToDto" likh kar hum aisa kar paa rahe hai...(maptoDto ko use karne ke liye hume "modelmapper" dependency add karni padti hai pom.xml file mai)
    }


}
