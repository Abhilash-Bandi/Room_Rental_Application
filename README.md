# Room_Rental_Application
### 📄 **Room Rental Application - README**

---

#### 🛠️ **Project Overview**
The **Room Rental Application** is a Java-based console application that allows users to:
- **Post** their properties for rent or sale.
- **Search** for rooms based on various filters (location, room type, price, etc.).
- **Delete** their posted rooms.
- **Display** their listed properties.
- **Make payments** for posting properties.

---

#### 🚀 **Features**
1. **User Authentication**
   - Login and Sign-up functionalities.
   - Option to reset the password.
2. **Room Management**
   - Add rooms for **rental** or **selling** purposes.
   - Filter search results by:
     - Location and locality.
     - Room type (PG/Hostel, Flat).
     - Room size (1BHK, 2BHK, Two/Three share).
     - Price range and deposit amount.
3. **Payment System**
   - Choose between **Card** or **UPI** payment methods.
   - Process commission payments (5% of the room price).
4. **User-Friendly Console UI**
   - Colored and formatted text for a better visual experience.
   - Multiple attempts for invalid inputs.

---

#### 🛠️ **Technologies Used**
- **Programming Language:** Java (Core Java concepts)
- **Packages:** 
  - `java.util` (for `ArrayList`, `Scanner`, etc.)
- **File Structure:**
  - `Main.java` → Contains the main execution logic, user authentication, and room management.
  - `Rooms.java` → Room details and operations.
  - `Property.java` → Property details (not fully viewed but appears to store property data).
  - `Payment.java` → Payment handling logic.
  - `User.java` (inferred but not uploaded) → Manages user details and authentication.
  
---

#### ⚙️ **How to Run**
1. **Compile the Files**
   ```bash
   javac Main.java Payment.java Rooms.java Property.java
   ```

2. **Run the Application**
   ```bash
   java Main
   ```

---

#### 🔥 **Usage Instructions**
1. **Login/Sign-up:** 
   - Choose `1` to log in or `2` to create a new account.
2. **Main Menu Options:**
   - `1` → Post a Room.
   - `2` → Search for available rooms.
   - `3` → Delete your posted room.
   - `4` → Display your listed properties.
   - `5` → Access additional services.
   - `6` → Logout.
3. **Room Posting:**
   - Choose rental or selling purpose.
   - Enter location, locality, room type, and size.
   - Provide an address, price, and deposit (optional).
   - Make payment (5% commission).
4. **Search and Filter:**
   - Choose room type, size, price range, and deposit filters.
5. **Payment:**
   - Choose `1` for Card or `2` for UPI.
   - Enter valid payment details.

---

#### 🛡️ **Error Handling**
- Invalid inputs trigger retry attempts.
- Payment validation handles incorrect card and UPI details.
- Incorrect login credentials prompt an error message.

---

#### **Future Enhancements**
- Add database support for persistent storage.
- Implement GUI for better user experience.
- Enhance security with encryption for sensitive data.
**Author:Abhilash  
 
