package org.nv95.openmanga

import android.app.Application
import android.content.res.Resources
import android.preference.PreferenceManager
import android.text.TextUtils
import com.fulldive.eventsender.lib.EventSender
import com.fulldive.eventsender.lib.EventSenderConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.nv95.openmanga.core.network.OpenMangaLogTree
import org.nv95.openmanga.di.appModule
import org.nv95.openmanga.di.dbModules
import org.nv95.openmanga.feature.sync.app_version.di.updateAppVersionModule
import org.nv95.openmanga.feature.worker.WorkerLauncher
import org.nv95.openmanga.items.ThumbSize
import org.nv95.openmanga.utils.AnimUtils
import org.nv95.openmanga.utils.FileLogger
import org.nv95.openmanga.utils.ImageUtils
import timber.log.Timber
import java.util.*

/**
 * Created by nv95 on 10.12.15.
 */
class OpenMangaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            if (BuildConfig.DEBUG) {
                androidLogger(Level.DEBUG)
            }

            androidContext(this@OpenMangaApplication)

            modules(listOf(appModule, dbModules, updateAppVersionModule))
        }

        FileLogger.init(this)
        val resources = resources
        val aspectRatio = 18f / 13f
        ThumbSize.THUMB_SIZE_LIST = ThumbSize(
                resources.getDimensionPixelSize(R.dimen.thumb_width_list),
                resources.getDimensionPixelSize(R.dimen.thumb_height_list)
        )
        ThumbSize.THUMB_SIZE_SMALL = ThumbSize(
                resources.getDimensionPixelSize(R.dimen.thumb_width_small),
                aspectRatio
        )
        ThumbSize.THUMB_SIZE_MEDIUM = ThumbSize(
                resources.getDimensionPixelSize(R.dimen.thumb_width_medium),
                aspectRatio
        )
        ThumbSize.THUMB_SIZE_LARGE = ThumbSize(
                resources.getDimensionPixelSize(R.dimen.thumb_width_large),
                aspectRatio
        )

        ImageUtils.init(this)
        AnimUtils.init(this)
        setLanguage(getResources(), PreferenceManager.getDefaultSharedPreferences(this).getString("lang", ""))
        // logger
        Timber.plant(OpenMangaLogTree())

        WorkerLauncher.runAll()

        // setup
        EventSenderConfig.apply {
            textPopupCustom = R.string.comFulldiveEventsender_textPopupCustom
        }
        EventSender.getInstance(this) // initialize
    }

    companion object {

        fun setLanguage(res: Resources, lang: String?) {
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = if (TextUtils.isEmpty(lang)) Locale.getDefault() else Locale(lang)
            res.updateConfiguration(conf, dm)
        }
    }
}
