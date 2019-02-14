package kz.seruen

class Place{
    var name: String? = null
    var info: String? = null

    constructor(){}

    constructor(name:String, info:String){
        this.name = name
        this.info = info
    }
}