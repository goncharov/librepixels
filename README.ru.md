# 500px-java-wrapper

   ***

   ## Зависимости

   - **signpost**
   - **org.json**

   ***

   ## Пример использования

   Библиотека сама не поддерживает OAuth-авторизацию, используйте для этого любую доступную библиотеку.
   Пример интеграции с библиотекой Signpost в классе SignpostHttpClient.

      OAuthConsumer consumer = new DefaultOAuthConsumer("consumer_key","consumer_secret");
      consumer.setTokenWithSecret("your_access_token", "your_access_secret");
      Px500 px500 = Px500Factory.createApi(consumer);
      UserProfile user = px500.getUser().byName("thegoncharov").get();
      System.out.println( user.toString() );

