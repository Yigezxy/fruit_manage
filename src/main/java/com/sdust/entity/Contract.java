package com.sdust.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
@Data
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler"})
public class Contract {
	private String contractId;
	private String barCode;
	private Integer type;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	private Retailer retailer;
	private List<CommoditiesVo> commoditiesList;

}
