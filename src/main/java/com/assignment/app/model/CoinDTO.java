package com.assignment.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="coin_price_history")
@Setter
@Getter
@NoArgsConstructor
public class CoinDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="price")
	private String price;
	
	@Column(name="timeStamp",nullable = false, updatable = false)
	@CreationTimestamp
	private Date timeStamp;
}
