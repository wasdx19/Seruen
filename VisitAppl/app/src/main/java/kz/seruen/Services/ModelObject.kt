package kz.seruen.Services

import kz.seruen.R

enum class ModelObject private constructor(val titleResId: Int, val layoutResId: Int) {

    RED(R.string.GP1, R.layout.activity_guide_page1),
    BLUE(R.string.GP2, R.layout.activity_guide_page2),
    GREEN(R.string.GP3, R.layout.activity_guide_page3)

}
