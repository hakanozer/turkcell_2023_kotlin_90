package com.example.nagihanarabaci

class Menu {

    companion object{
        private val userList = ArrayList<Users>()

        fun showMenu(){
            while (true){
                println("1- Show all users")
                println("2- Add new user")
                println("3- Delete user")
                println("4- Update user")
                println("5- Clear all users")
                println("6- Search user by name")
                println("7- Search user by phone")
                println("8- Exit")
                println("Seçiminiz: ")
                val chooice = readLine()!!.toInt()
                when(chooice){
                    1 -> showAllUsers()
                    2 -> addNewUser()
                    3 -> deleteUser()
                    4 -> updateUser()
                    5 -> clearAllUsers()
                    6 -> searchUserByName()
                    7 -> searchUserByPhone()
                    8 -> exit()
                    else -> println("Hatalı Seçim")
                }
            }

        }

        fun showAllUsers():ArrayList<Users>{

            if (userList.size == 0){
                usersListDefault()

            }else
            {
                 for (i in 0..userList.size-1){
                     println("Kullanıcı Adı ve Soyadı: ${userList[i].name}  ${userList[i].surname} " +
                             ",Kullanıcı Telefon Numarası: ${userList[i].phone}")
                 }

            }
            return userList

        }

        fun addNewUser():ArrayList<Users>{
            println("Kullanıcı adını giriniz: ")
            val userName = readLine()!!.toString()

            println("Kullanıcı soyadını giriniz: ")
            val userSurname = readLine()!!.toString()

            println("Kullanıcı telefonunu giriniz: ")
            val userPhone = readLine()!!.toString()

            val newUsers = Users(userName,userSurname,userPhone)
            userList.add(newUsers)
            return userList

        }

        fun deleteUser(){
            println("Silmek istediğiniz Kullanıcı Adını Giriniz : ")
            val userName = readLine()!!.toString()
            println("Silmek istediğiniz Kullanıcı Soyadını Giriniz : ")
            val userSurname = readLine()!!.toString()

            for (i in 0..userList.size-1){
                if (userList[i].name == userName && userList[i].surname == userSurname){
                    userList.removeAt(i)
                    println("Kullanıcı silindi")
                    break
                }else{
                    println("Kullanıcı bulunamadı")
                }
            }
        }

        fun updateUser(){
            println("Güncellemek istediğiniz Kullanıcı Adını Giriniz : ")
            val userName = readLine()!!.toString()
            for (i in 0..userList.size-1){
                if (userList[i].name == userName){
                    println("Kullanıcı adını giriniz: ")
                    val userName = readLine()!!.toString()

                    println("Kullanıcı soyadını giriniz: ")
                    val userSurname = readLine()!!.toString()

                    println("Kullanıcı telefonunu giriniz: ")
                    val userPhone = readLine()!!.toString()

                    val newUsers = Users(userName,userSurname,userPhone)
                    userList[i] = newUsers
                    println("Kullanıcı güncellendi")
                }else{
                    println("Kullanıcı bulunamadı")
                }
            }
        }

        fun clearAllUsers(){
            if (userList.size == 0){
                println("Kullanıcı listesi boş")
                return
            }else{
                userList.clear()
                println("Tüm kullanıcılar silindi")}
        }

        fun searchUserByName(){
            println("Aramak istediğiniz Kullanıcı Adını Giriniz : ")
            val userName = readLine()!!.toString()
            for (i in 0..userList.size-1){
                if (userList[i].name == userName){
                    println("Kullanıcı Adı ve Soyadı: ${userList[i].name}  ${userList[i].surname} " +
                            ",Kullanıcı Telefon Numarası: ${userList[i].phone}")
                }
            }
        }

        fun searchUserByPhone(){
            println("Aramak istediğiniz Kullanıcı Telefon Numarasını Giriniz : ")
            val userPhone = readLine()!!.toString()

            for (i in 0..userList.size-1){
                if (userList[i].phone == userPhone){
                    println("Kullanıcı Adı ve Soyadı: ${userList[i].name}  ${userList[i].surname} ")
                }
            }
        }

        fun exit(){
            println("Exit")
        }

        fun usersListDefault(): ArrayList<Users>{
            val user1 = Users("TUNGA","ÖZCANLI","123456789")
            val user2 = Users("MELİKE","ÖZKAYNAK","183456789")
            val user3 = Users("HİDAYET ","YILDIRIM","193456789")
            val user4 = Users("SEDA ELÇİM ","BATUR","193456789")
            val user5 = Users("MİNE CANSU ","ÖZCANLI","193456789")
            val user6 = Users("BUKET  ","KIRLANGIÇ","193456789")

            userList.add(user1)
            userList.add(user2)
            userList.add(user3)
            userList.add(user4)
            userList.add(user5)
            userList.add(user6)

            return userList
        }



    }


}