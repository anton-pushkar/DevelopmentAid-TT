# DevelopmentAid-TT
# Task 
Using the stackoverflow.com api documented at: https://api.stackexchange.com/docs retrievethe list of stack overflow users meeting the following criteria:
1. Are located in Romania or Moldova
2. Have a reputation of min 223 points.
3. Answered min 1 question
4. Have the tags: "java",".net","docker" or "C#" 
# Requirements:
- The code should be tracked with git and pushed to Github or Bitbucket.  The app should be written in Java (bonus points if written in Kotlin)
- The list of retrieved users should be dumped in a list in STDOUT.  Each line should contain:
- User name fields
1.     Location
2.     Answer count
3.     Question count
4.     Tags as a comma delimited string
5.     Link to profile
6.     Link to avatar
