package kz.visitapp2.Services;

import kz.visitapp2.R;

public enum ModelObject {

    RED(R.string.GP1, R.layout.activity_guide_page1),
    BLUE(R.string.GP2, R.layout.activity_guide_page2),
    GREEN(R.string.GP3, R.layout.activity_guide_page3);

    private int mTitleResId;
    private int mLayoutResId;

    ModelObject(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
