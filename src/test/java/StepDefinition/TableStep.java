package StepDefinition;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

public class TableStep {

	// 6 Order Details (Header + Multiple Rows)
	@When("user creates order with details")
	public void user_creates_order_with_details(DataTable dataTable) {

		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		for(Map<String, String> m : list) {
			System.out.println("item columns -> "+m.get("item"));
			System.out.println("quantity column ->"+m.get("quantity"));
			System.out.println("price column ->"+m.get("price"));
		}
	}

	// 3 Login With Header
	@When("user enters login credentials with header")
	public void user_enters_login_credentials_with_header(DataTable dataTable) {

		List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> m : map) {
			System.out.println(m.get("username"));
			System.out.println(m.get("password"));
		}
	}

	// 🔟 Product Creation (Header + Multiple Rows)
	@When("admin creates products with following details")
	public void admin_creates_products_with_following_details(DataTable dataTable) {

	}

	// 4️⃣ Single Row With Header
	@When("user enters single registration data")
	public void user_enters_single_registration_data(DataTable dataTable) {
		Map<String, String> map = dataTable.asMaps(String.class, String.class).get(0);
		System.out.println(map.get("username"));
		System.out.println(map.get("email"));
		System.out.println(map.get("password"));
	}

	// 5️⃣ Vertical Key-Value
	@When("user updates profile with following data")
	public void user_updates_profile_with_following_data(DataTable dataTable) {
		Map<String, String> list = dataTable.asMap(String.class, String.class);
		System.out.println("Key and value : "+list.get("username"));
		System.out.println("key and value : "+list.get("role"));
		System.out.println("key and value : "+list.get("status"));
		System.out.println("key and value : "+list.get("country"));

	}

	// 1️⃣ Single Column
	@When("user enters the following usernames")
	public void user_enters_the_following_usernames(DataTable dataTable) {
		List<String> list = dataTable.asList();

		for (String li : list) {
			System.out.println("users :" + li);
		}

	}

	// 8️⃣ Bank Account (Vertical Key-Value)
	@When("user submits bank account details")
	public void user_submits_bank_account_details(DataTable dataTable) {
        Map<String,String> zet= dataTable.asMap(String.class,String.class);
        
        System.out.println(zet.get("accountNumber"));
        System.out.println(zet.get("ifscCode"));
        System.out.println(zet.get("accountType"));
        System.out.println(zet.get("balance"));
	}

	// 9️⃣ Bulk User Creation
	@When("system processes following users")
	public void system_processes_following_users(DataTable dataTable) {

	}

	// 2️⃣ Login Without Header
	@When("user enters login credentials without header")
	public void user_enters_login_credentials_without_header(DataTable dataTable) {
		List<List<String>> list = dataTable.asLists(String.class);

		System.out.println(list.get(0).get(0)); // admin
		System.out.println(list.get(1).get(0)); // buyer
		System.out.println(list.get(2).get(1)); // guest123
	}

	// 7️⃣ API Request Body Creation
	@When("user sends API request with following body")
	public void user_sends_api_request_with_following_body(DataTable dataTable) {
           Map<String,String> map=   dataTable.asMaps(String.class,String.class).get(0);
           
           System.out.println("id : "+map.get("id"));
           System.out.println("name : "+map.get("name"));
           System.out.println("email : "+map.get("email"));
           System.out.println("role : "+map.get("role"));
	}
}
