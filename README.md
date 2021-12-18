# Covid-19-Management-Application


The COVID-19 pandemic has affected people in a severe manner, Testing and vaccination have become an important part of the current world, be it air travel or visiting elderly relatives getting tested and vaccinated has become a top priority. With the increase in testing and vaccinations, it has become significant to have a system to manage these procedures and keep a record. 

Our application aims to deliver a system to manage the vaccination and testing related information. The application aims to provide a user-friendly and easy-to-use system that: 
- Helps users manage their vaccination and testing related duties.
- Helps labs to manage the update of results and certificates for the user to access.
- 
# Technologies used:
- JDBC
- Window Builder
- rs2xml
- Swing


## System Design
<img src = "https://user-images.githubusercontent.com/71747053/146649595-2e561a66-ce06-4bea-9fd0-e3ccaf62d5f5.png" width = "700" height = "600"/>


## Screenshots Of The Application


### Fig. 1. The main page:

<img src = "https://user-images.githubusercontent.com/71747053/146649693-5c098e76-7b49-4e1b-b209-4a8005225571.png"/>


### Fig. 2. The user Sign-up page:

<img src = "https://user-images.githubusercontent.com/71747053/146649871-4bddeb97-a0d7-4004-a63c-29b49732e707.png"/>


### Fig. 3. Values entered during Sign-up:

<img src = "https://user-images.githubusercontent.com/71747053/146649871-4bddeb97-a0d7-4004-a63c-29b49732e707.png"/>


### Fig. 4. The database gets updated:

![image](https://user-images.githubusercontent.com/71747053/146650398-ece849e6-1ff5-4356-ad00-d78a2aa2f4a7.png)



### Fig. 5. The login page:

![image](https://user-images.githubusercontent.com/71747053/146650412-f1f90d6b-ec3d-48e2-9fe0-2559e4f6cdec.png)



### Fig. 6. If the credentials are valid, Login is successful:

![image](https://user-images.githubusercontent.com/71747053/146650421-008a0197-7bab-4fc5-a769-059dbb22dd88.png)


### Fig. 7. If the credentials are invalid, Login is unsuccessful:

![image](https://user-images.githubusercontent.com/71747053/146650440-097c9329-43de-46d5-b0cc-7c42d3028dc7.png)


### Fig. 8. If the login is successful, the user gets redirected to this page where they can choose whichever option they wish to:

![image](https://user-images.githubusercontent.com/71747053/146650454-2d93d53e-db49-491b-a4da-2d74cc087082.png)


### Fig. 9. Testing Booking Appointment Page:

![image](https://user-images.githubusercontent.com/71747053/146650536-c42db0da-9042-44dd-b784-d368bd5f2cac.png)


### Fig. 10. Once the user selects the city they wish to be tested in, they will be prompted to search labs in that city, after which they can accordingly select the lab they wish to:

![image](https://user-images.githubusercontent.com/71747053/146650546-7b99ded3-c393-41da-af37-3948599d0214.png)



### Fig. 11. Once all the details are valid and filled in, the test slot is booked:

![image](https://user-images.githubusercontent.com/71747053/146650577-87818be4-1516-4974-935d-7264dea3f33c.png)


### Fig. 12. The testing database gets updated accordingly as well:

![image](https://user-images.githubusercontent.com/71747053/146650585-0fdf49ff-a876-46c1-a754-7bbb4a6e628a.png)


### Fig. 13. View Appointment Page Here, the contents are uneditable:

![image](https://user-images.githubusercontent.com/71747053/146650597-5d2a4fdb-d217-4f27-ba7c-b5e2736fd35a.png)


### Fig. 14. Change Appointment Page. The user is prompted to change the date of their appointment:

![image](https://user-images.githubusercontent.com/71747053/146650618-2b469012-7d5b-4438-af83-d231b4b54235.png)


### Fig. 15. The date has been changed successfully:

![image](https://user-images.githubusercontent.com/71747053/146650633-431b6431-9a62-4d9e-9ddb-5a3bb8c18691.png)


### Fig. 16. If the user clicks on confirm cancellation. Their appointment gets deleted from our database:

![image](https://user-images.githubusercontent.com/71747053/146650639-de00a49b-7215-45b2-96ef-1d29e764d910.png)


### Fig. 17. Appointment cancelled successfully:

![image](https://user-images.githubusercontent.com/71747053/146650647-db2c64ad-0310-4771-8a54-25613de3b4fa.png)


### Fig. 18. Viewing the test result:

![image](https://user-images.githubusercontent.com/71747053/146650665-18fbb542-0db7-4db2-8c98-ef059c8acb95.png)


### Fig. 19. Book vaccination appointment Page:

![image](https://user-images.githubusercontent.com/71747053/146650676-5b0b25de-0bd0-4def-9f90-aa1bb25aefa0.png)


### Fig. 20. Vaccination appointment booked successfully:

![image](https://user-images.githubusercontent.com/71747053/146650711-06ef4fd7-7cfd-45b9-956a-9ed5b173b1d6.png)


### Fig. 21. Once an appointment is booked, our database gets updated accordingly:

![image](https://user-images.githubusercontent.com/71747053/146650759-da84e97c-a374-4292-9f5e-62efcf73e469.png)


### Fig. 22. In case the user wishes to view his appointment details again, they can do so by clicking on the View appointment option. Here, all the contents are uneditable:

![image](https://user-images.githubusercontent.com/71747053/146650779-031d9ab6-d145-478d-a490-4486d402f20d.png)


### Fig. 23. Changing the vaccination date, if the user wishes to:

![image](https://user-images.githubusercontent.com/71747053/146650793-8ac2d60b-777d-4d39-949c-064151ed1b7a.png)


### Fig. 24. The date is updated in our database:

![image](https://user-images.githubusercontent.com/71747053/146650807-d1bce63c-ba99-4679-a308-d1e1d7654ee6.png)


### Fig. 25. On comparing this figure and Fig. 22, we can see that the date column has been updated to the date in Fig. 24:

![image](https://user-images.githubusercontent.com/71747053/146650815-033bc686-02cc-4cbc-8452-8c9e449fedc2.png)


### Fig. 26. Here, the user receives his certificate once the lab has updated it:

![image](https://user-images.githubusercontent.com/71747053/146650824-6bf353ba-7b55-4e43-bddc-823151fa343c.png)


### Fig. 27. To prevent random users from making lab accounts, we have predefined some lab accounts based on the cities they are located in:

![image](https://user-images.githubusercontent.com/71747053/146650859-40fab8f3-6e2b-4dd5-b5f6-f1c030c3114b.png)


### Fig. 28. Lab Login Page:

![image](https://user-images.githubusercontent.com/71747053/146650868-b101c659-5964-42db-ae9f-b6e08bcb3d61.png)


### Fig. 29. This page appears when a Lab logs in with the correct credentials:

![image](https://user-images.githubusercontent.com/71747053/146650882-a7435b17-f30c-4aec-8bb8-180c6726014d.png)


### Fig. 31. Update Vaccination Result Page. If the lab chooses to update the vaccination results of patients who've been vaccinated, they can do so from this page:

![image](https://user-images.githubusercontent.com/71747053/146650947-60225e96-b087-438f-9564-f3f3e6dd19aa.png)


### Fig. 32. The lab needs to choose the person from the table and enter their phone number in the entry friend with the valid result and hit update to update the result:

![image](https://user-images.githubusercontent.com/71747053/146650954-ca6be5f2-b008-4b14-a46c-7e5aa0a58365.png)


### Fig. 33. If the result has been updated successfully, this pop-up appears:

![image](https://user-images.githubusercontent.com/71747053/146650976-b2f2391f-eacb-4a8f-927f-308b24a4b717.png)


### Fig. 34. Upon completion of updating, the name automatically disappears from the list:

![image](https://user-images.githubusercontent.com/71747053/146650988-0b506372-b93d-4b31-828c-b81ae14c74a8.png)


### Fig. 35. The database is updated successfully:

![image](https://user-images.githubusercontent.com/71747053/146651000-e40a013a-69e3-4ded-8fc2-387d310a75a0.png)



### Fig. 30. Update Test Result Page. If the lab chooses to update the test results of patients that have been tested, they can do so from this page:

![image](https://user-images.githubusercontent.com/71747053/146650903-ecdaa1d1-72aa-4dc9-a01d-e9fb4e136705.png)

