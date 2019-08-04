package com.ue.api.domain;

public class ResponseResult {

	public static final int Upload = 0;	// 上传文件
	
	private int businessType;		// 业务类型
	private int result;				// 结果返回值 
	private String errorInfo;		// 错误信息 
	private String DescriptionInfo;	// 描述信息	
	private Object data;			// 数据区域
	
	
	
}
