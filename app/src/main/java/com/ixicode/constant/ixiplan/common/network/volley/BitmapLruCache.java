package com.ixicode.constant.ixiplan.common.network.volley;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader.ImageCache;


/**
 *
 */
public class BitmapLruCache extends LruCache<String, Bitmap> implements ImageCache
{
    public BitmapLruCache()
    {
        this(getDefaultLruCacheSize());
    }

    public BitmapLruCache(int maxSize)
    {
        super(maxSize);
    }

    public static int getDefaultLruCacheSize()
    {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }

    @Override
    protected int sizeOf(String key, Bitmap value)
    {
        return value.getRowBytes() * value.getHeight();
    }

    @Override
    public Bitmap getBitmap(String url)
    {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap)
    {
        put(url, bitmap);
    }
}


