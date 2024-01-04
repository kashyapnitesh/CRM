package com.zohocrm.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity   // @Entity annotation is hibernate annotation
@Table(name = "contacts")  //@Table annotation is hibernate annotation.
@AllArgsConstructor
@NoArgsConstructor          // WHAT IS HIBERNATE AND WHY TO USE IT?
@Data                       //  Hibernate is an ORM(object-relational mapping) tool used to map java objects/POJO(plain old java objects)
                            //   and database   here the word "relational" means database table.

                            // HOW DOES THE MAPPING IS DONE B/W THE OBJECTS AND DATABASE TABLE?
                            // So basically hibernate provide us to two methods, with the help of these two methods we
                            // we can connect to the database table
                            //   methods are:1. JPA annotations, 2.Xml configuration

                            // INTERVIEWER MAY ASK QUESTION
                            // HOW CAN IN HIBERNATE YOU CAN USE JPA annotation?
                            // ANS.....that hibernate is nothing but implentation of JPA
                            //          JPA is an Interface and Hibernate is just like a class.
                            //          so here as we know agar interface to class(matlab interface se class mai inherit karna hai, yaha interface parent hoga)
                            //           to hum implement karte hai.....
                            //       class to class(extends)
                            //       interface to interface(extends)
                            //       interface to class(implements)
                            //       class to interface(nahi hota yaha inheritence).........

public class Contact {
    @Id                //@Id annotation is hibernate annotation.
    private String cid;
    @Column(name = "first_name",nullable = false)  //@Column annotation is hibernate annotation
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "mobile",nullable = false, unique = true)
    private long mobile;
    @Column(name = "lead_type",nullable = false)
    private String leadType;
    @Column(name = "address")
    private String address;
    @Column(name = "designation")
    private String designation;
    @Column(name = "company")
    private String company;
    @Column(name = "note")
    private String note;

}
