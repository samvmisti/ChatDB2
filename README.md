# ChatDB2
## Android developer test job for DB2 Limited.
Here is the screenshot of a main screen.
![Alt text](/screenshot.jpg "Channels screen")
## Test job description:
Please create 2 fully working screens.
[API first screen](https://iostest.db2dev.com/api/chat/channels/) and  
[API second screen](https://iostest.db2dev.com/api/chat/channels/1/messages/)
for both of them you need to authorize.<br />
### I used libraries:
I am getting all the data by retrofit2.<br /> 
For "channels" (list of chats) use TabLayout, ViewPager, <br />
with fragment RecyclerView (with customized RecyclerView.Adapter) inside ViewPager.<br />
Fragment has list of custom items.<br />
Tabs in TabLayout are also customized, as you see.<br />
For list of messages I use simple ListView with customized BaseAdapter.<br />
