package com.sts.dto.response;

import com.sts.enums.UserRole;

public record UserResponse(    Long id,
	    String email,
	    String name,
	    String phone,
	    String department,
	    UserRole role) {

}
