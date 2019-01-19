import com.google.gson.Gson;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;


public class ChatController {
    Chat chat;
    File chatFile;

    public ChatController(String nazvanie) {
        chatFile = new File("E:\\chats\\" + nazvanie);
        //если чат существует открываем его и загружаем сообщения
        if (chatFile.exists() && !chatFile.isDirectory()) {
            //todo загрузить файл в чат
            obnovitChat();
        } else {
            //иначе создаем пустой массив сообщений  и устанавливаем дату сообщнеий.
            chat = new Chat(nazvanie, "tema", new Date());
            //todo сохранить файл
            sohranitChat();
        }
    }

    public void sohranitChat(){
        Gson gson = new Gson();
        String chatJson = gson.toJson(chat);
        BufferedWriter bw = null;
        FileWriter fw = null;
        try{
            fw = new FileWriter(chatFile.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(chatJson);
            bw.flush();
            bw.close();
            fw.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void obnovitChat() {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(chatFile.getAbsolutePath()));
            String chatJson = new String(encoded, StandardCharsets.UTF_8);
            Gson gson = new Gson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dobavitSoobch(String soobch){
        obnovitChat();
        if(chat.getSoobchenie()==null){
            chat.setSoobchenie(new ArrayList<Soobch>());
        }
        chat.getSoobchenie().add(new Soobch(new Date(), soobch, "tema"));
        sohranitChat();
    }
}
