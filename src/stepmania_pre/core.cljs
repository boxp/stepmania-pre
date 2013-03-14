(ns stepmania-pre.core 
  (:require [goog.graphics :as Graphics]
            [goog.fx.dom :as Fxdom]
            [goog.fx.easing :as Easing]
            [goog.style :as Style]))

; 初期化＆丸を描画
(defn init-circle [x,y,r]
  (let [graphics (Graphics/createGraphics 512,512) ; 描画領域の初期化
        initialstroke (Graphics/Stroke. 2,"#000000") ; 線の生成
        initialfill (Graphics/SolidFill. "#ffff00")] ; 塗りつぶしの生成
    ; 丸の描画
    (doto graphics
      (.drawCircle x,y,r initialstroke initialfill)
      (.render js/circlecanvas))
    (array x y)
    ))

; 丸を動かす
(defn slide-circle [start x y anmtime] 
  (let [end (array x y)
        slide (Fxdom/Slide. js/circlecanvas,start,end,anmtime)]
    (. slide (play))))

(defn testMove [] (slide-circle (init-circle 200 200 100) 400 400 1000))

(set! (. js/window -onload) testMove)
