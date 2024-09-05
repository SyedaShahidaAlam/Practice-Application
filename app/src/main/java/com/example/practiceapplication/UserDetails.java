package com.example.practiceapplication;

public class UserDetails
{
    // Eikhane ID use kori ni karon...Id holo primary key...tai auto increment hobe
    private String name, email, username, password;

    // Right button e click...then Generate e click...then setter and getter e click...then ctrlA te click...then ok click
    // Eivabe dile setter and getter er shobgulo method chole ashbe

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}


