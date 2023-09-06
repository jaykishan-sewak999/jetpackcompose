package com.example.jetpackcomposedemo.dashboard

import com.google.gson.annotations.SerializedName

data class UsersListResponse(

	@field:SerializedName("data")
	val data: List<DataItem> = emptyList(),

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	var status: String? = null
)

data class DataItem(

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("employee_name")
	val employeeName: String? = null,

	@field:SerializedName("employee_salary")
	val employeeSalary: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("employee_age")
	val employeeAge: Int? = null
)
