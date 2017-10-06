# Spring-Boot-Solr

1. Download atau clone Spring-Boot-Solr di local
2. Download Solr di web official : http://www.apache.org/dyn/closer.lua/lucene/solr/7.0.0

Cara menjalankan Solr :
1. Masuk ke folder Solr/bin kemudian buka CMD dan ketik "solr start" (jika sudah bisa akses ke localhost:8983/solr)
2. Buat Solr CORE dengan CMD, ketik solr create -c product (SOLR CORE digunakan untuk menyimpan dan searching data)

--SETUP--
1. Import project pada IDE
2. Jalankan project
3. Silakhkan mencoba Add, Update, Search menggunakan POSTMAN

URL project : http://localhost:8080/

Contoh:

Misal ingin menambahkan product, bisa menggunakan API :

URL : http://localhost:8080/product/add
METHOD : POST
HEADERS : Content-Type : application/json
BODY : 
{
"id":"P123",
"name":"Product 1"
}

![alt text](https://scontent-sin6-1.xx.fbcdn.net/v/t35.0-12/22281147_1729869187108082_312477493_o.png?oh=9dfc81c569c3c4473b6e3a4d718fcbdc&oe=59DA0141)
