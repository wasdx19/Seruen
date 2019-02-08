package kz.visitapp2.Services

import kz.visitapp2.R

enum class ModelObject private constructor(val titleResId: Int, val layoutResId: Int) {

    RED(R.string.GP1, R.layout.activity_guide_page1),
    BLUE(R.string.GP2, R.layout.activity_guide_page2),
    GREEN(R.string.GP3, R.layout.activity_guide_page3)

}
