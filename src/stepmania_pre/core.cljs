(ns stepmania-pre.core 
  (:require [goog.graphics :as Graphics]
            [goog.fx.dom :as fxdom]))

; 初期化＆丸を描画
(defn init-circle [x,y,r]
  (let [graphics (Graphics/createGraphics 512,512) ; 描画領域の初期化
        initialstroke (Graphics/Stroke. 2,"#000000") ; 線の生成
        initialfill (Graphics/SolidFill. "#ffff00")] ; 塗りつぶしの生成
    ; 丸の描画
    (doto graphics
      (.drawCircle x,y,r initialstroke initialfill)
      (.render js/circlecanvas))
    (def start (array x y)
    )))

; 丸を動かす
(defn slide-circle [x y anmtime] 
  (let [end (array x y)
        slide (fxdom/Slide. js/circlecanvas,start,end,anmtime)]
    (.play slide)))

(defn testMove []
  (do 
    (init-circle 200 200 100)
    (slide-circle 400 400 1000)))

(set! (. js/window -onload) testMove)
