Feature: DataTable Practice Scenarios

  #just for edit############################################################
  # 1️⃣ Single Column DataTable
  ############################################################
 
  Scenario: Validate single column usernames
    When user enters the following usernames
      | admin  |
      | buyer  |
      | seller |

  ############################################################
  # 2️⃣ Multiple Rows Without Header
  ############################################################
  
  Scenario: Validate login details without header
    When user enters login credentials without header
      | admin | admin123 |
      | buyer | buyer123 |
      | guest | guest123 |

  ############################################################
  # 3️⃣ Multiple Rows With Header (Most Common)
  ############################################################
  
  Scenario: Validate login details with header
    When user enters login credentials with header
      | username | password  |
      | admin    | admin123  |
      | buyer    | buyer123  |
      | guest    | guest123  |

  ############################################################
  # 4️⃣ Single Row With Header
  ############################################################
  
  Scenario: Validate single user registration
    When user enters single registration data
      | username | password | email              |
      | admin    | admin123 | admin@test.com    |

  ############################################################
  # 5️⃣ Vertical Key-Value DataTable
  ############################################################
  Scenario: Validate profile update form
    When user updates profile with following data
      | username | admin   |
      | role     | buyer   |
      | status   | active  |
      | country  | India   |

  ############################################################
  # 6️⃣ Order Details With Numeric Values
  ############################################################
  Scenario: Validate order creation
    When user creates order with details
      | item    | quantity | price |
      | Pen     | 10       | 20    |
      | Pencil  | 5        | 15    |
      | Book    | 2        | 300   |

  ############################################################
  # 7️⃣ API Request Body Creation
  ############################################################
  Scenario: Create API user using DataTable
    When user sends API request with following body
      | id | name  | email             | role   |
      | 1  | John  | john@test.com     | admin  |

  ############################################################
  # 8️⃣ Bank Account Details (Real-time Example)
  ############################################################
  @demo
  Scenario: Validate bank account creation
    When user submits bank account details
      | accountNumber | 1234567890 |
      | ifscCode      | SBIN000123 |
      | accountType   | Savings    |
      | balance       | 50000      |

  ############################################################
  # 9️⃣ Multiple Users Converted to POJO
  ############################################################
  Scenario: Validate bulk user creation
    When system processes following users
      | username | password  | role    |
      | admin    | admin123  | admin   |
      | buyer    | buyer123  | buyer   |
      | seller   | seller123 | seller  |

  ############################################################
  # 🔟 Complex Product Creation (E-commerce Example)
  ############################################################
  Scenario: Validate product creation
    When admin creates products with following details
      | productName | category   | price | stock |
      | Chair       | Furniture  | 5000  | 10    |
      | Table       | Furniture  | 8000  | 5     |
      | Lamp        | Lighting   | 1500  | 20    |
