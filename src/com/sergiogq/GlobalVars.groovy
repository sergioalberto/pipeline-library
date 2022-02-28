#!/usr/bin/env groovy
package com.sergiogq

class GlobalVars {
    static String foo = "bar"

    // refer to this in a pipeline using:
    //
    // import com.sergiogq.GlobalVars
    // println GlobalVars.foo
}
