package com.webappclouds.samplekotlin

import java.lang.Integer.parseInt

/**
 * Created by user on 2/1/2017.
 */

open class Sample(i: Int) {

    constructor(s:String):this(1){

    }

}

class SampleChild(i: Int) : Sample(2) {
}

fun sample(){
    var s = SampleChild(1)
}
