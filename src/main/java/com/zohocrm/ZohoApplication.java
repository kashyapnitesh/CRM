package com.zohocrm;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ZohoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZohoApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();         // The line return new ModelMapper(); is a Java statement that creates a new instance of the ModelMapper class and returns it.

		                                    //Let's break it down:

		                                    //1. new ModelMapper(): This part of the code creates a new object of the ModelMapper class. In Java, the new keyword is used to instantiate a new object of a class.

		                                  //2.   return: This keyword is used to exit a method and return a value. In this context, it means that the newly created ModelMapper object will be returned from the method.

				                              //So, when this line is executed within a method, it means that the method is designed to return a new instance of the ModelMapper class to the caller. The calling code can then use the returned ModelMapper object for further operations or assignments
	}




}
