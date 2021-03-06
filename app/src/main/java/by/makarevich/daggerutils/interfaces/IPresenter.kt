package by.makarevich.daggerutils.interfaces

interface IPresenter{
    fun showDialog(text: String)
}

abstract class IAttachablePresenter<T> {

    protected var callback: T? = null

    open fun onAttachedToWindow(callback: T) {
        this.callback = callback
    }

    open fun onDetachedFromWindow() {
        this.callback = null
    }
}