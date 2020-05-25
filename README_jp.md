# プロジェクトタイトル

# 日本の名言

<img width="396" alt="LoginView" src="https://user-images.githubusercontent.com/43265235/82762623-03131f80-9e3d-11ea-9756-f303e1771e0b.png">

## 開発きっかけ

<p>私は個人的に疲れたりしんどい時、言葉に励まされる。</p> 
<p>恋愛をどうしたらいいか分からない時、友人関係が悪くなった時、毎日の日常に飽きた時など励ましを受けるために、
「いい言葉」を検索し、様々な名言に触れた</p>

<h3>日本語を勉強をする際、ふと、「日本にはどのような名言があるのか​​？」</h3>

<p>という疑問を持つようになり、探したところ、日本の名言をまとめたサイトが韓国には存在しないことがわかりました。</p>


## 実行方法

1. データベースの追加

 「Japanese Saying - DB.txt」にある項目を順序通りに追加する。


2. SayingDAO.javaに入り、 jdbcUrl,id,pwdを変更する。
```
  // 該当　データベースの名前を "JapaneseSaying"の代わりに入れる。
　String jdbcUrl = "jdbc:mysql://localhost:3306/JapaneseSaying";
　String id　= "root";
　String pwd = "root";
````
3. mysql-connector-java-5.1.48-bin.jarをダウンロードし, ライブラリに追加

4. Start.javaに入って実行

   #### MACで開発したため、Windowsで実行する際、画面がイメージのように表示されない場合があり。


<p>管理者画面に入りたい場合</p>
<p>LoginView.javaで「id : admin / pwd : admin」を入力 </p>

<p>ユーザー画面に入りたい場合</p>
<p>LoginView.javaでUserInfoデータベースの中で　userID, userPwdから一つ選択し、入力.</p>


## 提供サービス

- シンプルなデザイン
- ユーザーごとにログイン数に応じてランキングを見れる機能導入
- 各名言のクリック数に応じたランキング機能導入
- 日本の名言に対する韓国語翻訳機能
- 管理者画面において簡単な名言また、ユーザー管理機能提供

## 今後の改善点

-　コメント機能 
-　管理者画面のCRUDのRead/Update機能 
-　名言検索機能

<img width="399" alt="AdminView" src="https://user-images.githubusercontent.com/43265235/82763529-5c7e4d00-9e43-11ea-991a-44b88cb5e924.png">

<img width="396" alt="SignUpView" src="https://user-images.githubusercontent.com/43265235/82763532-6011d400-9e43-11ea-89cb-3f8dfde874f5.png">

<img width="398" alt="InquiryOrder" src="https://user-images.githubusercontent.com/43265235/82763533-60aa6a80-9e43-11ea-839e-fba5df4221df.png">

<img width="394" alt="OneofSayingView" src="https://user-images.githubusercontent.com/43265235/82763534-61430100-9e43-11ea-9133-4de124914c1c.png">

