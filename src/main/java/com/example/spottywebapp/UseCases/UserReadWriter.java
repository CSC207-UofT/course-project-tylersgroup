package com.example.spottywebapp.UseCases;


import com.example.spottywebapp.entities.UserList;

import java.io.*;

public class UserReadWriter implements ReadWriter {

    private Object IOException;

    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param users    stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(String filePath, Object users) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(users);
        output.close();
        buffer.close();
        file.close();
    }

    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of users
     * @throws IOException
     */
    @Override
    public UserList readFromFile(String filePath) throws IOException, ClassNotFoundException {
        try {
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream(buffer);
            // serialize the Map
            UserList users = (UserList) input.readObject();
            input.close();
            buffer.close();
            file.close();
            return users;
        }catch(IOException e){
            return new UserList();
        }
    }

}