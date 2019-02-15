package kz.seruen

class Place{
    var name: String? = null
    var info: String? = null
    var type: String? = null

    constructor(){}

    constructor(name:String, info:String, type:String){
        this.name = name
        this.info = info
        this.type = type
    }
}